package edu.badpals.romans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final String numero;
    private short decimalNum = 0;
    public static final String romanRegex = "[M]";

    public RomanNumber(String numeroRomano) {
        this.numero = numeroRomano;
    }

    public short getDecimalNum() {
        return decimalNum;
    }

    @Override
    public String toString(){
        return this.numero;
    }

    public short toDecimal(){
        Matcher m = matcherCreator();
        while (m.find()){
            SimbolosRomanos simbolos = Enum.valueOf(SimbolosRomanos.class, String.valueOf(m.group()));
            decimalNum += (short) simbolos.getValorDecimal();
        }
        return getDecimalNum();
    }

    private Matcher matcherCreator(){
        Pattern p = Pattern.compile(romanRegex);
        Matcher m = p.matcher(this.numero);
        return m;
    }
}
