#lang racket

(define (quadrat x)
  (* x x))

(define (mittelwert x y)
  (/ (+ x y) 2))

(define (verbessern estimation x)
  (mittelwert estimation (/ x estimation)))

(define (enough estimation x)
  (< (abs (- (quadrat estimation) x)) 0.00001))


(define (wurzel-iter estimation x)
  (if (enough estimation x)
      estimation
      (wurzel-iter (verbessern estimation x) x)))

(define (wurzel x)
  (wurzel-iter 1.0 x))
