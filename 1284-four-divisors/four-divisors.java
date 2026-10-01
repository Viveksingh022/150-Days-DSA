class Solution {

    // Ye function ek number ke divisors count karega
    // Agar exactly 4 divisors hue to unka sum return karega
    // warna 0 return karega.
    int findSumDivisor(int num){

        int count = 0;
        int sum = 0;

        // Sirf sqrt(num) tak hi check karna hota hai
        // kyunki ek divisor milta hai to uska pair bhi mil jata hai.
        for(int i = 1; i * i <= num; i++){

            if(num % i == 0){

                int secondFactor = num / i;

                // Agar dono divisor same hain
                // matlab perfect square hai.
                if(secondFactor == i){
                    count += 1;
                    sum += i;
                }
                else{
                    // Dono alag-alag divisors hain
                    count += 2;
                    sum += (i + secondFactor);
                }
            }

            // Agar divisors 4 se zyada ho gaye
            // to hume aage check karne ki zarurat nahi.
            if(count > 4)
                return 0;
        }

        // Agar exactly 4 divisors hain to sum return karo
        return count == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {

        int result = 0;

        // Array ke har number ke liye check karo
        for(int num : nums){

            // Agar uske exactly 4 divisors hain
            // to unka sum result me add kar do.
            result += findSumDivisor(num);
        }

        return result;
    }
}
