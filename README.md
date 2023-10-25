# text-compressor
A text compression tool written as part of Coding challenges

### Tree Builder
For the input
```commandline
Given there is usually an unequal distribution of character occurrences in text 
this can then be used to compress data by giving the most commonly occurring characters the shortest prefix.
```
The tree built looks like below
```commandline
Tree
{ 188 { 77 { 35 {e 17 _ _} { 18 {u 8 _ _} { 10 {m 4 _ _} { 6 {b 3 _ _} {y 3 _ _}}}}} { 42 { 20 {a 10 _ _} {o 10 _ _}} { 22 {n 11 _ _} {i 11 _ _}}}} { 
111 { 50 { 24 {c 12 _ _} {s 12 _ _}} { 26 { 13 { 6 { 3 {G 1 _ _} {p 2 _ _}} {g 3 _ _}} { 7 {d 3 _ _} { 4 {x 2 _ _} { 2 {. 1 _ _} {q 1 _ _}}}}} {r 13 _ _}}} 
{ 61 {  29 _ _} { 32 { 16 { 8 { 4 {f 2 _ _} {v 2 _ _}} {l 4 _ _}} {h 8 _ _}} {t 16 _ _}}}}}

CharacterCodeBase
{codes={G=1010000,  =110, a=0100, b=001110, c=1000, d=101010, e=000, f=1110000, g=101001, h=11101, i=0111, l=111001, 
m=00110, n=0110, .=10101110, o=0101, p=1010001, q=10101111, r=1011, s=1001, t=1111, u=0010, v=1110001, x=1010110, y=001111}}
```