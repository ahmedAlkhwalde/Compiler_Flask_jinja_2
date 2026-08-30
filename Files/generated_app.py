from flask import Flask, render_template, request, redirect, url_for
from werkzeug.utils import secure_filename
import os
app = Flask(__name__)
UPLOAD_FOLDER = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'static', 'images')
os.makedirs(UPLOAD_FOLDER, exist_ok=True)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
products = [{'id': 1, 'name': 'Laptop', 'price': 750, 'image': 'images.jfif', 'image_url': '/static/images/images.jfif'}, {'id': 2, 'name': 'Headphones', 'price': 120, 'image': 'images_1.jfif', 'image_url': '/static/images/images_1.jfif'}, {'id': 3, 'name': 'Camera', 'price': 500, 'image': 'images.jfif', 'image_url': '/static/images/images.jfif'}]
@app.route('/')
def show_products():
    for p in products:
        p['image_url'] = url_for('static', filename=f"images/{p['image']}")
    return render_template('products.html', products=products)

@app.route('/product/<int:pid>')
def product_details(pid):
    product = next((p for p in products if p['id'] == pid), None)
    if product:
        product['image_url'] = url_for('static', filename=f"images/{product['image']}")
    return render_template('products.html', product=product)

@app.route('/add', methods=['GET', 'POST'])
def add_product():
    global products
    if request.method == 'POST':
        new_id = (max([p['id'] for p in products]) + 1) if products else 1
        form_keys = list(request.form.keys())
        if 'price' in form_keys:
            form_keys.remove('price')
        if 'image' in form_keys:
            form_keys.remove('image')
        if form_keys:
            name_key = form_keys[0]
        else:
            name_key = 'name'
        name = request.form[name_key]
        price = float(request.form['price'])
        file = request.files['image']
        filename = secure_filename(file.filename)
        file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
        products.append({'id': new_id, 'name': name, 'price': price, 'image': filename})
        return redirect('/')
    return render_template('products.html', add_form=True)

@app.route('/delete/<int:pid>', methods=['POST'])
def delete_product(pid):
    global products
    products = [p for p in products if p['id'] != pid]
    return redirect('/')

@app.after_request
def __sync_products_state(response):
    try:
        __new_state = 'products = ' + str(products)
        __changed = True
        try:
            with open('Files/.products_state.txt', 'r', encoding='utf-8') as __rf:
                if __rf.read() == __new_state:
                    __changed = False
        except Exception:
            pass
        if __changed:
            with open('Files/.products_state.txt', 'w', encoding='utf-8') as __sync_f:
                __sync_f.write(__new_state)
    except Exception:
        pass
    return response

if __name__ == '__main__':
    app.run(debug=True)
