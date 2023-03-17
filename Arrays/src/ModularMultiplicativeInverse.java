public class ModularMultiplicativeInverse {
        public int solve(int A, int B)
        {
            return pow(A, B-2, B);
        }

        private int pow(int A, int p, int B)
        {
            if (p == 0) return 1;

            if (p % 2 == 1)
            {
                long halfp = pow(A, p/2, B);
                return (int) ((A%B * halfp%B * halfp%B)%B);
            }
            else
            {
                long halfp = pow(A, p/2, B);
                return (int) ((halfp%B * halfp%B)%B);
            }
        }
}
