package model;

public enum Specie {
    AVES("aves"),AVES_ORNAMENTALES("Aves ornamentales (canarios, pericos, loros)"),
    BORREGOS("Borregos"),BOVINOS("Bovinos"),CACHORROS("Cachorros"),CANINOS("Caninos"),
    CAPRINOS("Caprinos"),CONEJOS("Conejos"),EQUINOS("Equinos"),FELINOS("Felinos"),
    LECHONES("Lechones"), OVICAPRINOS("Ovicaprinos"),OVINOS("Ovinos"),
    PEQUEÑOS_FELINOS("Pequeños Felinos"), PORCINOS("Porcinos"),POTROS("Potros"),TERNEROS("Terneros"),
    TERNERAS("Terneros");

    Specie(String valueEnum) {
        this.valueEnum = valueEnum;
    }
    private String valueEnum;

    public String getValueEnum() {
        return valueEnum;
    }
}
