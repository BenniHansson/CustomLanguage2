push 11
pop Winston
push 0
pop Julia
push 1
pop i
push 1
pop j
label enterLoop1
push i
push 101
lt
not
if-goto exitLoop1
label enterLoop2
push j
push 3
lt
not
if-goto exitLoop2
push i
pop Julia
push i
push 1
add
pop i
goto enterLoop2
label exitLoop2
goto enterLoop1
label exitLoop1
push Winston
push Julia
sub
pop Winston
push Julia
print versificatorJulia
push Winston
print versificatorWinston
