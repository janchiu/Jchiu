// Janson Chiu and Yuxi Ma 
// jaachiu yma71
// 12M
// Block.c
// This files creates the block in the block chain 

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Block.h"


typedef struct BlockObj{
   char* data;
   int id;
   long hash; 
}BlockObj;

Block newBlock(char* data, int id, long hash){
   Block B = malloc(sizeof(BlockObj));
   assert(B!=NULL);
   B->id = id;
   B->data = data;
   B->hash = hash;
   return B;
}
void freeBlock(Block* pB){
   
   free(pB->id = NULL);
   free(pB->data = NULL); 
   free(pB->hash = NULL);
}


long hash(Block B){ //edit
   long sum = 0;
   char* rand = data(B);
   for(int i = 0 ; i<strlen(data); i++){
      sum += (long) rand[i];
   } 
   return (long)(sum + B->id + previousHash(B));
   // return (long)(data(B)+B->id + previousHash(B));
   // return B->hash; 
   //return int(data(B))+ B->id + previousHash(B);
}

long previousHash(Block B){
   return B->hash;
} 

char* data(Block B){
   return B->data;
}

void printBlock(FILE* out, Block B){
   if(B==NULL ){
       fprintf(stderr, "Block Error: calling printBlock() on NULL Block reference\n");
       exit(EXIT_FAILURE);
   }
   fprintf(out, "%d ", B->id);
   fprintf(out, "%s ", ":");
   fprintf(out, "%d ", B->data);
}
