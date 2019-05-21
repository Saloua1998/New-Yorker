package com.example.newyorker;

public class Clothes {
    private String Merk;
    private String Prijs;

    public Clothes() { }

    public Clothes(String merk, String prijs) {
        Merk = merk;
        Prijs = prijs; }

    public String getMerk() {
        return Merk; }

    public void setMerk(String merk) {
        Merk = merk; }

    public String getPrijs() {
        return Prijs; }

    public void setPrijs(String prijs) {
        Prijs = prijs; }
}
