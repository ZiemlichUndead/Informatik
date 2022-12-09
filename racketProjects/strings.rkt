#lang racket

(define (teilstring s von bis)
(list->string (teilstring-rek (string->list s) von bis 1)))
(define (teilstring-rek s von bis jetzt)
(cond ((or (null? s) (> jetzt bis)) '())
((< jetzt von) (teilstring-rek (cdr s) von bis (+ jetzt 1)))
(else (cons (car s) (teilstring-rek (cdr s) von bis (+ jetzt 1))))))

(define (lefttrimstring s)
(list->string (lefttrimstring-rek (string->list s) #t)))
(define (lefttrimstring-rek s anfang)
    (cond ((null? s) '())
((and anfang (char=? (car s) #\space))
(lefttrimstring-rek (cdr s) #t))
(else (cons (car s) (lefttrimstring-rek (cdr s) #f)))))