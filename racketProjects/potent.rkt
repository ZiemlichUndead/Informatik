#lang racket
(define (potenz b n)
  (if (= n 0)
      1
      (* b (potenz b (- n 1)))))

(define (potenz1 b n)
  (potenz-iter 1 b n))

(define (potenz-iter product b n)
  (if (= n 0)
      product
      (potenz-iter (* b product) b (- n 1))))

(define (grade? x)
  (= (remainder x 2)))
(define (quadrat x)
  (* x x))
(define (schnellpotenz b n)
  (cond ((= n 0) 1)
        ((even? n) (quadrat (schnellpotenz b (/ n 2))))
        (else (* b (schnellpotenz b (- n 1))))))
