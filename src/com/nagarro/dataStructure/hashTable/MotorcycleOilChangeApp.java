package com.nagarro.dataStructure.hashTable;

public class MotorcycleOilChangeApp {
    private BasicHashTable<String, String> toolset = new BasicHashTable<>(12);

    public static void main(String[] args) {
        MotorcycleOilChangeApp app = new MotorcycleOilChangeApp();
        app.changeOil();
    }

    public void changeOil() {
        buildToolset();

        removeSkidPlate();

        drainAndReplaceOil();

        replaceSkidPlate();

        emptyToolset();
    }

    private void buildToolset() {
        toolset.insert("8mm", "8mm Socket");
        toolset.insert("10mm", "10mm Socket");
        toolset.insert("12mm", "12mm Socket");
        toolset.insert("14mm", "14mm Socket");
        toolset.insert("17mm", "17mm Socket");
        toolset.insert("1/4sae", "1/4sae Socket");
        toolset.insert("3/8sae", "3/8sae Socket");
        toolset.insert("1/2sae", "1/2sae Socket");
        toolset.insert("5/8sae", "5/8sae Socket");
        toolset.insert("3/4sae", "3/4sae Socket");
        toolset.insert("1/4d", "1/4 socket wrench");
        toolset.insert("2de", "2 inch Drive extension");
        System.out.println("Toolset size: " + toolset.size());
    }

    private void emptyToolset() {
        toolset.delete("8mm");
        toolset.delete("10mm");
        toolset.delete("12mm");
        toolset.delete("14mm");
        toolset.delete("17mm");
        toolset.delete("1/4sae");
        toolset.delete("3/8sae");
        toolset.delete("1/2sae");
        toolset.delete("5/8sae");
        toolset.delete("3/4sae");
        toolset.delete("1/4d");
        toolset.delete("2de");
        System.out.println("Toolset size: " + toolset.size());
    }

    private void removeSkidPlate() {
        //get the 10mm socket and wrench
        String socket = toolset.getValueByKey("10mm");
        String wrench = toolset.getValueByKey("1/4d");
        System.out.println("Removed 4 skid plate nuts with the " + socket + " and " + wrench);
    }

    private void replaceSkidPlate() {
        String socket = toolset.getValueByKey("10mm");
        String wrench = toolset.getValueByKey("1/4d");
        System.out.println("Replaced 4 skid plate nuts with the " + socket + " and " + wrench);
    }

    private void drainAndReplaceOil() {
        System.out.println("Toolset has 17mm socket: " + toolset.containsValue("17mm Socket") + " - " + toolset.containsKey("17mm"));

        String socket = toolset.getValueByKey("17mm");
        String wrench = toolset.getValueByKey("1/4d");
        System.out.println("Removed oil drain plug with " + socket + " and " + wrench);
        System.out.println("Drained 1.7 quarts of oil");
        System.out.println("Replaced oil drain plug with " + socket + " and " + wrench);
        System.out.println("Added 1.7 quarts of oil");
    }
}
