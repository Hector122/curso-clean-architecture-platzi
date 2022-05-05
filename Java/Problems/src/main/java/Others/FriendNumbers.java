package Others;

public class FriendNumbers {
    /* Se dice que dos números son amigos si la suma de los divisores de uno es igual al otro.
     Se desea que implemente una función que reciba dos números enteros, positivos,
     y decida si los mismos son números amigos o no.

     Especificación de la Entrada
     La primera y única linea de la entrada contendrá dos enteros a y b separados por un espacio.

     Especificación de la Salida
     Debe imprimir una unica linea con el texto True si los números son amigos o False de no serlo.*/

    static Boolean solution(int a, int b) {
        // your code goes here
        if (a == sumDiv(b) && b == sumDiv(a)) return true;

        return false;
    }

    static int sumDiv(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
