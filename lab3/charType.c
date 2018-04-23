//Janson Chiu 
//jaachiu
//charType.c
//12M
//This file reads a line of input and determines what the type of the character is

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extract_chars(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments 
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file                  
   FILE* out;       // handle for output file                 
   char* line;      // string holding input line              
   char* alpha; // string holding all alpha-numeric chars
   char* num; 
   char* punc; //string holding all the punctuation chars
   char* white;
   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }
   int count = 1;
   // allocate strings line and alpha_num on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alpha = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   num = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   punc = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   white = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   assert( line!=NULL && alpha!=NULL && punc!=NULL && num!=NULL && white!=NULL);

   // read each line in input file, extract alpha-numeric characters 
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_chars(line, alpha, num, punc, white);
      fprintf(out, "%s", "line ");
      fprintf(out,"%d", count);
      fprintf(out, "%s\n", " contains:"); 
      if(strlen(alpha)>1){
         fprintf(out, "%lu", strlen(alpha));
         fprintf(out, "%s", " alphabetic characters: ");
         fprintf(out, "%s\n", alpha);
      }else{
         fprintf(out, "%lu", strlen(alpha));
         fprintf(out, "%s", " alphabetic character: ");
         fprintf(out, "%s\n", alpha);
      }
      if(strlen(num)>1){
         fprintf(out, "%lu", strlen(num));
         fprintf(out, "%s", " numeric characters: ");
         fprintf(out, "%s\n", num);
      }else{ 
         fprintf(out, "%lu", strlen(num));
         fprintf(out, "%s", " numeric character: ");
         fprintf(out, "%s\n", num);
      }
      if(strlen(punc)>1){
         fprintf(out, "%lu", strlen(punc));
         fprintf(out, "%s", " punctuation characters: ");
         fprintf(out, "%s\n", punc);
      }else{
         fprintf(out, "%lu", strlen(punc));
         fprintf(out, "%s", " punctuation character: ");
         fprintf(out, "%s\n", punc);
      }
      if(strlen(white)>1){
         fprintf(out, "%lu", strlen(white));
         fprintf(out, "%s", " whitespace characters: ");
         fprintf(out, "%s\n", white);
      }else{ 
         fprintf(out, "%lu", strlen(white)); 
         fprintf(out, "%s", " whitespace character: ");
         fprintf(out, "%s\n", white);
      }
      count++;
   }

   // free heap memory 
   free(line);
   free(alpha);
   free(num);
   free(punc);
   free(white);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extract_chars(char* s, char* a, char* d, char* p, char* w){
   int i=0;
   int j=0;
   int countd = 0; 
   int countp = 0; 
   int countw = 0; 
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){ 
      if(isalnum(s[i])){
         if(isalpha(s[i])){
            a[j++] = s[i];
         }else{
            d[countd++] = s[i];
         }
      }else if(ispunct(s[i])){
         p[countp++] = s[i];
      }else if(isspace(s[i])){
         w[countw++] = s[i];
      }
      i++;
   }
   a[j] = '\0';
   d[countd] = '\0';
   p[countp] = '\0';
   w[countw] = '\0';
}
        
