#include <stdio.h>
#include <stdlib.h>
int score[10]; // initialized score
struct mcqs // structured mcqs for store more than one value for we don't have to use different variables for storing values
{
int no;
char qno[200],op1[200],op2[200],op3[200],op4[200]; // used char and op variables with arrays to store strings in mcqs variable
int ansNo;
}
mcqs[10]={ // used array for storing 10 mcqs
{1,"What is the 16-bit compiler allowable range for integer constants?","-3.4e38 to 3.4e38"," -32767 to 32768","-32668 to 32667","-32768 to 32767",4},
{2,"What is required in each C program","The program must have at least one function.","The program does not require any function.","Input data","Output data",1},
{3,"Which of the following comment is correct when a macro definition includes arguments?","The opening parenthesis should immediately follow the macro name.",
"There should be at least one blank between the macro name and the opening parenthesis.",
"There should be only one blank between the macro name and the opening parenthesis.",
"All the above comments are correct",1},
{4,"What is a lint?","C compiler","Interactive debugger","Analyzing tool","C interpreter",3},
{5,"What is the output of this statement printf(%d, (a++))?","The value of (a + 1)","The current value of a","Error message","Garbage",2},
{6,"Why is a macro used in place of a function?","It reduces execution time.","It reduces code size.","It increases execution time.","It increases code size.",4},
{7,"In the C language, the constant is defined _.","Before main","After main","Anywhere, but starting on a new line.","None of the these.",3},
{8,"A pointer is a memory address. Suppose the pointer variable has p address 1000, and that p is declared to have type int*, and an int is 4 bytes long. What address is represented by expression p + 2?",
"1002","1004","1006","1008",4},
{9,"Which one of the following is a loop construct that will always be executed once?","for","while","switch","do while",4},
{10,"Directives are translated by the","Pre-processor","Compiler","Linker","Editor",1},};
int main()
{
char c;
int i,j,t=0;
printf("\t\t\t\t--------------------------------------\n");
printf("\t\t\t\t\t     MCQs Examination \n");
printf("\t\t\t\t--------------------------------------\n");
printf("\tEnter y to take the test OR n to terminate :");
c = getch();
if(c=='y') // used condition y and n to take decision
{
for(i=0;i<10;i++) // used for loop for running a loop for mcqs (questions and options)
gen_mcq(i);
for(j=0;j<10;j++) // used loop for count corrected answers
t+=score[j];
printf("\t\t\t----------------------------------------------------------\n");
printf("\t\t\t\t\tYou got %d corrected.\n",t);
printf("\t\t\t----------------------------------------------------------\n");
int avg;
avg =t*100/10;
printf("\t\t\t\t\tThe corrected percentage is %d \n ",avg);
printf("\t\t\t----------------------------------------------------------\n");
if(avg>=90)
{
    printf("\t\t\t\t\tYour Grade is A\n");
    printf("\t\t\t----------------------------------------------------------\n");
}
else if(avg>=80&&avg<=89)
{
    printf("\t\t\t\t\tYour Grade is B\n");
    printf("\t\t\t----------------------------------------------------------\n");
}
else if(avg>=70&&avg<=79)
{
    printf("\t\t\t----------------------------------------------------------\n");
    printf("\t\t\t\t\tYour Grade is C\n");
}
else if(avg>=60&&avg<=69)
{
    printf("\t\t\t\t\tYour Grade is D\n");
    printf("\t\t\t----------------------------------------------------------\n");
}
else if(avg>=50&&avg<=59)
{
    printf("\t\t\t\t\tYour Grade is E\n");
    printf("\t\t\t----------------------------------------------------------\n");
}
else if(avg<50)
{
    printf("\t\t\t\t\tYour Grade is F\n");
    printf("\t\t\t----------------------------------------------------------\n");
}
if(avg<10)
{
    printf("\t\t\t\t\tYour performance is too low \n\t\t\t\t\tYou need at least (5) corrected ");
    printf("\n\t\t\t----------------------------------------------------------\n");
}
else if(avg<20)
{
    printf("\t\t\t\t\tYour performance is too low \n\t\t\t\t\tYou need at least (4) more corrected ");
    printf("\n\t\t\t----------------------------------------------------------\n");
}
else if(avg<30)
{
    printf("\t\t\t\t\tYour performance is too low \n\t\t\t\t\tYou need at least (3) more corrected ");
    printf("\n\t\t\t----------------------------------------------------------\n");
}else if(avg<40)
{
    printf("\t\t\t\t\tYour performance is low \n\t\t\t\t\tYou need at least (2) more corrected ");
    printf("\n\t\t\t----------------------------------------------------------\n");
}else if(avg<50)
{
    printf("\t\t\t\t\tYour performance is low \n\t\t\t\t\tYou need at least (1) more corrected ");
    printf("\n\t\t\t----------------------------------------------------------\n");
}
printf("\nDo you want to retake the test?\npress y OR press any key to terminate\n");
   char a;
   a = getch();
   if (a=='y')
   {
       main();
   }
   else
   {
       printf("\n\tTerminating.\n\n");
       sleep(2);
       printf("\n\t\t\t----------------------------------------------------------\n");
       printf("\t\t\t\t\tterminated");
       printf("\n\t\t\t----------------------------------------------------------\n");
   }
}
return 0;
}
int gen_mcq(int Qno) // used function to divide program and print the questions
{
int n;
printf("\n\n\tQ%d. %s",mcqs[Qno].no,mcqs[Qno].qno);
printf("\n\n\t1.\t%s\t\t2.\t%s\t",mcqs[Qno].op1,mcqs[Qno].op2);
printf("\n\n\t3.\t%s\t\t4.\t%s\t",mcqs[Qno].op3,mcqs[Qno].op4);
printf("\n\t Enter your selected answer :");
scanf("%d",&n);
if(n==mcqs[Qno].ansNo)
    score[Qno]=1; // used condition for assign a point on correct ans
else
score[Qno]=0;

return Qno;
}

