#lang racket

(define (fakultät n)
  (if(= n 1)
     1
     (* n (fakultät (- n 1)))))

(define (fak n)
  (fak-iter 1 1 n))

(define (fak-iter multiplier counter n)
  (if (> counter n)
      multiplier
      (fak-iter (* counter multiplier) (+ counter 1) n)
      )
  )


(define (fib n)
  (fib-iter 0 1 n))

(define (fib-iter z1 z2 n)
  (if (= n 0)
      z1
      (fib-iter z2 (+ z1 z2) (- n 1))))
