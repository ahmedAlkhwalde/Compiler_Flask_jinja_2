package ASTFlask.SymbolTable;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class VariableSymbol extends Symbol {
    public Object value;
    public Map<String, Object> attributes;
    private Map<String, VariableSymbol> nestedFields;
    private String parentPath;
    private Set<String> fieldNames;

    public VariableSymbol(String name, String type, int line, Scope scope) {
        super(name, type, line, scope);
        this.value = null;
        this.attributes = new HashMap<>();
        this.nestedFields = new HashMap<>();
        this.parentPath = null;
        this.fieldNames = new HashSet<>();

        initializeAttributesByType(type);
    }

    public VariableSymbol(String name, String type, int line, Scope scope, Object value) {
        super(name, type, line, scope);
        this.value = value;
        this.attributes = new HashMap<>();
        this.nestedFields = new HashMap<>();
        this.parentPath = null;
        this.fieldNames = new HashSet<>();

        initializeAttributesByType(type);
        processValue(value);
    }

    private void initializeAttributesByType(String type) {
        String normalizedType = type.toLowerCase();

        if (normalizedType.contains("list") || normalizedType.contains("array")) {
            this.attributes.put("is_list", true);
            this.attributes.put("element_type", "any");
        } else if (normalizedType.contains("dict") || normalizedType.contains("map")) {
            this.attributes.put("is_dict", true);
        } else if (normalizedType.contains("tuple")) {
            this.attributes.put("is_tuple", true);
        } else if (normalizedType.contains("set")) {
            this.attributes.put("is_set", true);
        }
    }

    private void processValue(Object value) {
        if (value == null) {
            return;
        }

        if (value instanceof List) {
            List<?> list = (List<?>) value;
            this.attributes.put("length", list.size());
            this.attributes.put("is_list", true);

            detectElementTypes(list);

            processListElements(list);
        }
        else if (value instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) value;
            this.attributes.put("size", map.size());
            this.attributes.put("is_dict", true);

            extractFieldNamesFromMap(map);

            processMapElements(map);
        }
    }

    private void detectElementTypes(List<?> list) {
        Set<String> elementTypes = new HashSet<>();
        boolean hasDicts = false;
        boolean hasLists = false;

        for (Object item : list) {
            if (item instanceof Map) {
                elementTypes.add("dict");
                hasDicts = true;
            } else if (item instanceof List) {
                elementTypes.add("list");
                hasLists = true;
            } else if (item instanceof String) {
                elementTypes.add("str");
            } else if (item instanceof Integer || item instanceof Long) {
                elementTypes.add("int");
            } else if (item instanceof Double || item instanceof Float) {
                elementTypes.add("float");
            } else if (item instanceof Boolean) {
                elementTypes.add("bool");
            } else {
                elementTypes.add("any");
            }
        }

        if (elementTypes.size() == 1) {
            this.attributes.put("element_type", elementTypes.iterator().next());
        } else {
            this.attributes.put("element_type", "mixed");
        }

        this.attributes.put("has_dicts", hasDicts);
        this.attributes.put("has_lists", hasLists);
    }

    private void processListElements(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) item;

                for (Object key : map.keySet()) {
                    if (key instanceof String) {
                        String fieldName = key.toString();
                        fieldNames.add(fieldName);

                        VariableSymbol nestedField = new VariableSymbol(
                                fieldName,
                                inferType(map.get(key)),
                                this.line,
                                this.scope
                        );
                        nestedField.setParentPath(this.name);

                        nestedFields.put(fieldName, nestedField);
                    }
                }
            }
        }
    }

    private void extractFieldNamesFromMap(Map<?, ?> map) {
        for (Object key : map.keySet()) {
            if (key instanceof String) {
                fieldNames.add(key.toString());
            }
        }
        this.attributes.put("fields", new ArrayList<>(fieldNames));
    }

    private void processMapElements(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                String fieldName = entry.getKey().toString();
                Object fieldValue = entry.getValue();

                String fieldType = inferType(fieldValue);

                VariableSymbol nestedField = new VariableSymbol(
                        fieldName,
                        fieldType,
                        this.line,
                        this.scope,
                        fieldValue
                );
                nestedField.setParentPath(this.name);

                nestedFields.put(fieldName, nestedField);

                if (fieldValue instanceof Map || fieldValue instanceof List) {
                    nestedField.processValue(fieldValue);
                }
            }
        }
    }

    private String inferType(Object value) {
        if (value == null) {
            return "None";
        } else if (value instanceof String) {
            return "str";
        } else if (value instanceof Integer || value instanceof Long) {
            return "int";
        } else if (value instanceof Double || value instanceof Float) {
            return "float";
        } else if (value instanceof Boolean) {
            return "bool";
        } else if (value instanceof List) {
            return "list";
        } else if (value instanceof Map) {
            return "dict";
        } else {
            return "any";
        }
    }

    public void setValue(Object value) {
        this.value = value;
        this.nestedFields.clear();
        this.fieldNames.clear();
        processValue(value);
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    @Override
    public String toString() {
        String valueStr = "";
        if (value != null) {
            if (value instanceof String) {
                valueStr = "\"" + value + "\"";
            } else if (value instanceof List) {
                valueStr = "List[" + ((List<?>) value).size() + " items]";
            } else if (value instanceof Map) {
                valueStr = "Dict[" + ((Map<?, ?>) value).size() + " entries]";
            } else {
                valueStr = value.toString();
            }
        } else {
            valueStr = "null";
        }

        String nestedInfo = "";
        if (!nestedFields.isEmpty()) {
            nestedInfo = " [Fields: " + nestedFields.keySet() + "]";
        }

        return "Variable(" + name + ":" + type + " = " + valueStr + nestedInfo + " at line " + line + ")";
    }

}