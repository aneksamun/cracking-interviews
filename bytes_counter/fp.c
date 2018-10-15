#ifdef HAVE_CONFIG_H
#include <config.h>
#endif

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
   FILE *in, *out;
   int n = 0;
   char buf[20], ch;

   system("clear");

   if(argc != 2)
   {
      printf("Syntax: [program] [file name].\n");
      exit(1);
   }

   if((in = fopen(argv[1], "r")) == NULL)
   {
      printf("Error on source file opening.\n");
      exit(1);
   }

   if((out = fopen("out", "w+")) == NULL)
   {
      printf("Error on result file opening.\n");
      exit(1);
   }

   while(!feof(in)) {
      ch = getc(in);
      if (!feof(in))
      {
         putchar(ch);
         ++n;
      }
   }

   printf("\n\nSymbols (without 'EOF', but with '\\n'): %d\n", n);

   // int fseek(FILE *fp, long int byte_quantity, int start_of_counter)
   if (fseek(in, -50L, SEEK_END))
   {
       printf("Error on file seeking.\n");
       exit(1);
   }

   printf("Position after seeking: %i\n", ftell(in));

   // size_t fread(void *buffer, size_t byte_quantity, size_t counter, FILE *fp)
   n = fread(buf, sizeof(char), 20, in);
   buf[n] = '\0';

   fseek(out, 0, SEEK_SET);
   fprintf(out, "%s", buf);

   printf("20 byte string (result saved in out file):\n\n");
   printf("--------------------\n");

   rewind(out);
   ch = getc(out);

   while(ch != EOF)
   {
      putchar(ch);
      ch = getc(out);
   }

   printf("\n--------------------\n");
   
   if (in != NULL)
   {
      fclose(in);
      in = NULL;
   }

   if (out != NULL)
   {
       fclose(out);
       out = NULL;
   }

   return EXIT_SUCCESS;
}
