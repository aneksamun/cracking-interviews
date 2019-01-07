using static System.Console;

public static class Matrix
{
        /// <summary>
        /// Prints matrix
        /// 1 0 0 0 0 0 0 0
        /// 0 1 0 0 0 0 0 0
        /// 0 0 1 0 0 0 0 0
        /// 0 0 0 1 0 0 0 0
        /// 0 0 0 0 1 0 0 0
        /// 0 0 0 0 0 1 0 0
        /// 0 0 0 0 0 0 1 0
        /// 0 0 0 0 0 0 0 1
        /// </summary>
        public static void PrintFromRightToLeft()
        {
            var value = 1;

            for (var i = 0; i < 8; i++)
            {
                for (var t = 128; t > 0; t /= 2)
                {
                    Write((value & t) != 0 ? "1 " : "0 ");
                }

                WriteLine();
                value <<= 1;
            }
        }

        /// <summary>
        /// Prints matrix
        /// 0 0 0 0 0 0 0 1
        /// 0 0 0 0 0 0 1 0
        /// 0 0 0 0 0 1 0 0
        /// 0 0 0 0 1 0 0 0
        /// 0 0 0 1 0 0 0 0
        /// 0 0 1 0 0 0 0 0
        /// 0 1 0 0 0 0 0 0
        /// 1 0 0 0 0 0 0 0
        /// </summary>
        public static void PrintFromLeftToRight()
        {
            var value = 128;

            for (var i = 0; i < 8; i++)
            {
                for (var t = 128; t > 0; t /= 2)
                {
                    Write((value & t) != 0 ? "1 " : "0 ");
                }

                WriteLine();
                value >>= 1;
            }
        }
}

