// Janson Chiu and yuxi ma 
// jaachiu yma71
// 12M
// Blockchain.c 
// This program creates the block chain

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Blockchain.h"
#include"Block.c"

typedef struct BlockchainObj{
   Block* blocks[100];
   int numOfItems;
   
}BlockchainObj;

Blockchain newBlockchain(){
   Blockchain B = malloc(sizeof(BlockchainObj));
   assert(B!=NULL);
   B->numOfItems = 0;
   return B; 
} 

void freeBlockchain(Blockchain* pB){
   if(pB!=NULL && *pB!=NULL){
      while(size(*pB)>0){
          removeLast(*pB);
      }
      free(*pB);
      *pB = NULL;
   }
}

//create a new block
int append(Blockchain B, char* data){
   if(valid(B) == 1){
      long newHash;
      if(size(B) == 0){
         newHash = 0;
      }else { 
         newHash = hash(get(B, size(B)-1));
      } 
   B->blocks[size(B)] = newBlock(data, size(B), newHash);
   B->numOfItems = size(B)+1;
   return size(B);
   }else{ 
      return 0;
   }
}

int size(Blockchain B){
   return B->numOfItems;
}

Block get(Blockchain B, int idx){
   return B->blocks[idx];
}

int valid(Blockchain B){
   if(size(B) <= 1){
      return 1;
   }
   for(int i=size(B)-1; i>0;i--){
      if(previousHash(get(B,i)) == hash(get(B,i-1))){
         return 1;
      }else{
         return 0;
      }
   }
}
void removeLast(Blockchain B){
/*
   if(B==NULL){
       fprintf(stderr, "Blockchain Error: calling removeLast() on NULL Block reference\n");
       exit(EXIT_FAILURE);
   }else{
       freeBlock(size(B)-1);
       B->numOfItems = size(B)-1;
   }
 */
   B->numOfItems = size(B) -1;
   Block C = get(B, size(B));
   freeBlock(&C);
}

void printBlockchain(FILE* out, Blockchain B){
   for(int i =0;i<size(B);i++){
      printBlock(out, B->blocks[i]);
   }
}

