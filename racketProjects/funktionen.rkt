#lang racket

(define (mittelwert x y)
(/ (+ x y) 2))

(define (nah-genug? x y)
(< (abs (- x y)) 0.00001))


(define (suche f neg-punkt pos-punkt)
(let ((mittelpunkt (mittelwert neg-punkt pos-punkt)))
(if (nah-genug? neg-punkt pos-punkt)
mittelpunkt
(let ((test-wert (f mittelpunkt)))
(cond ((positive? test-wert)
(suche f neg-punkt mittelpunkt))
((negative? test-wert)
(suche f mittelpunkt pos-punkt))
(else mittelpunkt))))))

(define (fixpunkt f erste-schaetzung)
(define (versuch schaetzung)
(let ((naechstes (f schaetzung)))
(if (nah-genug? schaetzung naechstes)
naechstes
(versuch naechstes))))
(versuch erste-schaetzung))
