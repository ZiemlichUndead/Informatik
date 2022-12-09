#lang racket

(define (isnumber? x)
x)

(define (test )
   (isnumber? 0 0))

(define (konstr-summe a1 a2)
  (cond ((number? a1 0) a2)
        ((isnumber? a2 0) a1)
        ((and (number? a1) (number? a2)) (+ a1 a2))
        (else (list '+ a1 a2))))