push 11
pop Winston
push 0
pop Julia
push 1
pop i
label enterLoop
push Julia
push 101
lt
not
if-goto exitLoop
push i
pop Julia
push i
push 1
add
pop i
goto enterLoop
label exitLoop
push Winston
push Julia
sub
pop Winston
push Julia
Julia
push Winston
Winston
