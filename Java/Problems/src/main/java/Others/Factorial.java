package Others;

public class Factorial {
    //iterative
    public long FirstFactorialIterative(int num) {

        if (num == 0 || num == 1) return 1;

        int result = 1;
        while(num > 1){
            result *= num;
            num--;
        }

        return result;
    }

    // Recursive
    public long FirstFactorialRecursive(int num) {

        if (num == 0 || num == 1) return 1;

        return num * FirstFactorialRecursive(num - 1);
    }
}
