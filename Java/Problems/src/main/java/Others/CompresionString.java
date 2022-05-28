package Others;

import java.util.HashMap;
import java.util.Map;

public class CompresionString {
    // ABBBBCFLL	A4BCF2L
    /* Algoritmo de Compresión

    Allowed languages
    Java, Java, Kotlin, Plain Text
    En Mahisoft la seguridad es muy importante y por esto fue desarrollado un algoritmo de encriptacion muy seguro que,
    como resultado, entrega una cadena de caracteres compuesta únicamente de letras mayúsculas. Accidentalmente,
    se descubrió que con mucha frecuencia la misma letra ocurría varias veces de manera consecutiva,
    y se observó que se podía aprovechar esta cualidad para comprimir la cadena de texto.

    Se pide de su ayuda para implementar un método que, dada una cadena de caracteres como entrada,
    retorne la misma cadena pero reemplazando caracteres seguidos repetidos por el número de apariciones de dicho carácter,
     seguido del caracter en sí.

    Especificación de la Entrada
    La primera y única linea de la entrada contendrá una cadena de letras en mayusculas sin ningún tipo de separacion.

    Especificación de la Salida
    Debe imprimir una única linea con la correspondiente compresión de los caracteres. */


    static String solution(String s) {
        // your code goes here
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length() ; i++){
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        StringBuilder str = new StringBuilder();

        for (Character name: map.keySet()) {
            String key = name.toString();
            Integer value = map.get(name);

            if(value > 1) str.append(value.toString()); //add value
            str.append(key); // add key

            System.out.println(key + " " + value);
        }

        return str.toString();
    }
}
