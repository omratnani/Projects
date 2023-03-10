.model small
.stack 100h
 newline macro p1,p2
    mov ah,2
	mov dl, 0ah
	int 21h   
    mov dl, 0dh
    int 21h   
 endm 
 
 input macro p1
	newline
	mov ah, 1
	int 21h   
 endm  
 
 print macro p1
    mov ah,9
	int 21h
 endm
 
 
 
.data    

msg1 db '================== MCQs Based Examination ==================$'
msg2 db '====================        Rules     ==========================$'
msg3 db '*. For every correct answer you will get 1 point.$'
msg4 db '*. For every wrong answer 1 point will cut from your total point.$'
msg5 db 'press enter to start the quiz : $'
msg6 db 'Correct answer$'
msg7 db 'Wrong answer$'
msg8 db 'You have successfully completed your quiz.$'
msg9 db 'Your total obtained point is : $'
msg10 db 'Press 1 to re-attempt quiz or 0 to exit.$' 
msg11 db '                    *Thankyou$'  
msg12 db '---------------------------------------------------------------$'  
msg13 db '======================== Quiz question ========================$' 
msg14 db 'Enter your answer: $'


q1 db '1.what is the 16-bit compiler allowable range for integer constants? $'
a1 db '   a) -3.4e38 to 3.4e38   '
   db ,10,13,'   b) -32767 to 32768'    
   db ,10,13,'   c) -32668 to 32667'   
   db ,10,13,'   d) -32768 to 32767 $'
q2 db 'what is required in each c program$'
a2 db '   a) the program must have at least one function.   '
   db ,10,13,'   b) the program does not require any function    '
   db ,10,13,'   c) input data'
   db ,10,13,'   d) output data$'
q3 db '3.which of the following comment is correct when a macro definition includes '
   db ,10,13,'   arguments?$'
a3 db '   a) the opening parenthesis should immediately follow the macro name.'  
   db ,10,13,'   b) there should be at least one blank between the macro name and'
   db ,10,13,'      the opening parenthesis.   '
   db ,10,13,'   c) there should be only one blank between'
   db ,10,13,'      the macro name and the opening parenthesis '
   db ,10,13,'   d) all the above comments are correct $'
q4 db '4.what is a lint?$'
a4 db '   a) c compiler interactive debugger '
   db ,10,13,'   b)interactive debugger'
   db ,10,13,'   c) analyzing tool '
   db ,10,13,'   d) c interpreter$'
q5 db '5.what is the output of this statement printf(%d, (a++))?$'
a5 db '   a) the value of (a + 1). '
   db ,10,13,'   b) the current value of (a)   '
   db ,10,13,'   c) error message '
   db ,10,13,'   d) garbage $'
q6 db '6.why is a macro used in place of a function?$'
a6 db '   a) it reduces execution time. '
   db ,10,13,'   b) it reduces code size '
   db ,10,13,'   c) it increases execution time '
   db ,10,13,'   d) it increases code size. $'
q7 db '7.in the c language, the constant is defined ___.$'
a7 db '   a) before main '
   db ,10,13,'   b) after main '
   db ,10,13,'   c) anywhere, but starting on a new line.'
   db ,10,13,'   d) none of the these. $'
q8 db '8.a pointer is a memory address. suppose the pointer variable has p address 1000,'
   db ,10,13,'      and that p is declared to have type int*, and an int is 4 bytes long.'
   db ,10,13,'      what address is represented by expression p + 2?$'
a8 db '   a) 1002 '
   db ,10,13,'   b) 1004 '
   db ,10,13,'   c) 1006 '
   db ,10,13,'   d) 1008 $'
q9 db '9.which one of the following is a loop construct that will always be executed once?$'
a9 db '   a) for '
   db ,10,13,'   b) while' 
   db ,10,13,'   c) switch '
   db ,10,13,'   d) do while $'
q10 db '10. directives are translated by the_________.$'
a10 db '   a) pre prosesor '
   db ,10,13,'   b) compiler '
   db ,10,13,'   c) linker '
   db ,10,13,'   d) editor $'

.code
main proc 
    
    mov ax,@data
	mov ds,ax
    
	lea dx,msg1
	print
	newline
    
	lea dx,msg2
	print
    newline
    
	lea dx,msg3
	print
    newline
    
	lea dx,msg4
	print
	
	start:
	mov bl, 0  
    newline
    
	lea dx,msg5
	print
	input
	
	cmp al, 0dh
	je qsn1
	jne start
	
	qsn1:
	newline
    
	lea dx,q1
	print
	newline
    
	lea dx,a1
	print
	newline
    lea dx,msg14
	print
	input
	
	cmp al, 'd'
	je qsn2
    jne qsnw2
	
	qsn2:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn2  
	newline
	lea dx,msg14
	print 
	input
	
	cmp al, 'a'
	je qsn3
	jne qsnw3
	
	qsnw2:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn2 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'a'
	je qsn3 
	jne qsnw3
	
	
	qsn3:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline   

    
	call qn3
	newline
	lea dx,msg14
	print 
    input
	
	cmp al, 'a'
	je qsn4
	jne qsnw4
	
	qsnw3:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn3 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'a'
	je qsn4 
	jne qsnw4
	
	qsn4:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn4
	newline
	lea dx,msg14
	print 
	input
	
	cmp al, 'c'
	je qsn5
	jne qsnw5
	
	qsnw4:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn4 
	newline
	lea dx,msg14
	print 
    input
	
	cmp al, 'c'
	je qsn5 
	jne qsnw5
	
	qsn5:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn5 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'b'
	je qsn6
	jne qsnw6
	
	qsnw5:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn5 
	newline
	lea dx,msg14
	print 
	input
	
	cmp al, 'b'
	je qsn6 
	jne qsnw6
	
	qsn6:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn6 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'd'
	je qsn7
	jne qsnw7
	
	qsnw6:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn6
	newline 
	lea dx,msg14
	print
	input
	
	cmp al, 'c'
	je qsn7 
	jne qsnw7
	
	qsn7:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn7
	input
	
	cmp al, 'c'
	je qsn8
	jne qsnw8
	
	qsnw7:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn7 
	input
	
	cmp al, 'c'
	je qsn8 
	jne qsnw8
	
	qsn8:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn8 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'd'
	je qsn9
	jne qsnw9
	
	qsnw8:
	newline
    
	lea dx,msg7
    print
	
	dec bl
	newline
    
	call qn8 
	newline
	lea dx,msg14
	print 
	input
	
	cmp al, 'd'
	je qsn9 
	jne qsnw9
	
	qsn9:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn9 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'd'
	je qsn10
	jne qsnw10
	
	qsnw9:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn9 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'd'
	je qsn10 
	jne qsnw10
	
	qsn10:
	newline
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	call qn10
	newline
	lea dx,msg14
	print 
	input
	
	cmp al, 'a'
	je exit
	jne exitw
	
	qsnw10:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	call qn10 
	newline
	lea dx,msg14
	print
	input
	
	cmp al, 'a'
	je exit 
	jne exitw
	
exit:
	newline 
    
	lea dx,msg6
	print
	
	inc bl
	newline
    
	lea dx,msg8
	print
	newline
    
	lea dx,msg9
	print
	
	add bl, 48
	
	cmp bl,57
	jg ten
	mov ah, 2
	mov dl, bl
	int 21h
	jmp exit1
	
exitw:
	newline
    
	lea dx,msg7
	print
	
	dec bl
	newline
    
	lea dx,msg8
	print 
	newline
    
	lea dx,msg9
	print
	
	add bl,48
	mov ah,2
	mov dl, bl
	int 21h
	
	jmp exit1
	
ten:
	mov ah,2
	mov dl,"1"
	int 21h  
	mov dl,"0"
	int 21h
	jmp exit1
    
qn2:
    lea dx,q2
	print
	newline
    
	lea dx,a2
	print
	ret 
	
qn3:
    lea dx,q3
	print
	newline
    
	lea dx,a3
	mov ah,9
	int 21h
	ret
	
qn4:
    lea dx,q4
	print
	newline
    
	lea dx,a4
	print
	ret
	
qn5:
    lea dx,q5
	print
	newline
    
	lea dx,a5
	print
	ret 
	
qn6:
    lea dx,q6
	print
	newline
    
	lea dx,a6
	print
	ret
	
qn7:
    lea dx,q7
	print
	newline
    
	lea dx,a7
	print
	ret 
	
qn8:
    lea dx,q8
	print
	newline
    
	lea dx,a8
	print
	ret  
	
qn9:
    lea dx,q9
	print
	newline
    
	lea dx,a9
	print
	ret 
	
qn10:
    lea dx,q10
	print
	newline
    
	lea dx,a10
	print
	ret  
	
exit1: 
	newline
	
	lea dx,msg10
	print
	
	mov ah,1
	int 21h
	
	cmp al,'1'
	je start 
	newline
	
	lea dx,msg11
	print
	
	mov ah, 4ch
	int 21h
	
	main endp
end main
