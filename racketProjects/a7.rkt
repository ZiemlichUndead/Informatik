#lang racket
(define (nat-wurzel n)
  (nat-wurzel-iter 1 1 1 n))

(define (nat-wurzel-iter summe counter summanden n)
  (if(>= summe n)
     summanden
     (nat-wurzel-iter (+ summe (+ counter 2)) (+ counter 2) (+ summanden 1) n)))


(define (reverse n)
  (reverse-iter n 0 1))

(define (reverse-iter n result counter)
  (if (= n 0)
      result
      (reverse-iter (quotient n 10) (+ (* 10 result) (remainder n 10)) (+ counter 1))))
  
  















