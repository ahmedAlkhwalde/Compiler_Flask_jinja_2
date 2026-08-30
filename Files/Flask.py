from flask import Flask, render_template, request, redirect, url_for
from werkzeug.utils import secure_filename
import os

app = Flask(__name__)
UPLOAD_FOLDER = 'static/images'
os.makedirs(UPLOAD_FOLDER, exist_ok=True)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

# قائمة المنتجات الافتراضية
products = [
   {"id": 1, "name": "Laptop", "price": 750, "image": "images.jfif"},
    {"id": 2, "name": "Headphones", "price": 120, "image": "headphones.jpg"},
    {"id": 3, "name": "Camera", "price": 500, "image": "camera.jpg"},
]

@app.route("/")
def show_products():
    for p in products:
        p["image_url"] = url_for('static', filename=f"images/{p['image']}")
    return render_template("products.html", products=products)

@app.route("/product/<int:pid>")
def product_details(pid):
    product = next((p for p in products if p["id"] == pid), None)
    if product:
        product["image_url"] = url_for('static', filename=f"images/{product['image']}")
    return render_template("products.html", product=product)

@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        new_id = len(products) + 1

        # 1. جلب قائمة بجميع مفاتيح الفورم المرسلة كقائمة بسيطة يفهمها الكومبايلر بسهولة
        form_keys = list(request.form.keys())

        # 2. إزالة مفتاح السعر ومفتاح الصورة إذا كانا موجودين، ليبقى فقط مفتاح الاسم
        if "price" in form_keys:
            form_keys.remove("price")
        if "image" in form_keys:
            form_keys.remove("image")

        # 3. المفتاح المتبقي الأول هو اسم المنتج ديناميكياً (في حالتك سيكون "ahmed")
        if form_keys:
            name_key = form_keys[0]
        else:
            name_key = "name"

        # جلب القيمة الفعلية للاسم ديناميكياً بناءً على المفتاح الذي عثرنا عليه
        name = request.form[name_key]

        # جلب بقية الحقول (السعر والملف) بشكل طبيعي
        price = float(request.form["price"])
        file = request.files["image"]
        filename = secure_filename(file.filename)
        file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))

        # إضافة المنتج الجديد إلى القائمة
        products.append({
            "id": new_id,
            "name": name,
            "price": price,
            "image": filename
        })
        return redirect("/")

    return render_template("products.html", add_form=True)

@app.route("/delete/<int:pid>", methods=["POST"])
def delete_product(pid):
    products = [p for p in products if p["id"] != pid]
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)

