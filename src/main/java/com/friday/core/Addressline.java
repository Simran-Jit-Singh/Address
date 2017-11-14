package com.friday.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addressline {

    // A method to take the address as string and return its fields
    public static String[] getAddressFields(String addressString) {
        StringBuffer sBuffer = new StringBuffer();
        String streetName = "", streetNumber = "";
        if (addressString == null)
            throw new NullPointerException();

        if (addressString.isEmpty()) {
            return new String[]{streetName, streetNumber};
        }

        Pattern p = Pattern.compile("(\\s+([\\d]+)([a-zA-Z]+)$)|" // ex: '12B'
                + "(\\s+([a-zA-Z]+)([\\d]+))$|" // ex: 'B12'
                + "\\s+([\\d]+)\\s*([a-zA-Z]?)$|" // ex: '12 B'
                + "(\\s+(?i)[no]+\\s+([\\d]+))$|" // ex: 'no 42'
                + "(^([\\d]+)\\s*)"); // ex: '12' or '12 B'

        Matcher m = p.matcher(addressString);
        while (m.find()) {
            sBuffer.append(m.group());
        }
        streetNumber = sBuffer.toString();
        streetName = addressString.replaceAll(streetNumber, "");

        streetName = streetName.replaceAll("\\W\\s", "");
        streetNumber = streetNumber.replaceAll("[\\W]?\\s", "");

        return new String[]{streetName, streetNumber};
    }

}
