grammar EZQL;

statement
:
	(
		selectdb '|'
	)? expr
	(
		'|' expr
	)*
	(
		('|')? function_group_by
	)?
	(
		limitclause
	)? ';'
;

selectdb
:
	DB '>>' field
;

DB
:
	'DB'
	| 'db'
;

limitclause
:
	'limit' NUMBER
;

expr
:
	predicate
	(
		OR predicate
	)*?
	| text_predicate
;

text_predicate
:
	(
		text
	)*
;

predicate
:
	singleValuePredicate
	| multiValuePredicate
	| rangePredicate
;

singleValuePredicate
:
	field OPS text
;

multiValuePredicate
:
	field MULTI_VAL_OPS values
;

rangePredicate
:
	field BETWEEN '(' low ',' high ')'
;

low
:
	text
;

high
:
	text
;

values
:
	text
	| '(' text
	(
		',' text
	)* ')'
;

field
:
	QTEXT
	| UQTEXT
;

function_group_by
:
	function
	(
		'by' field
		(
			',' field
		)*
	)?
;

text
:
	NUMBER
	| QTEXT
	| UQTEXT
;

MULTI_VAL_OPS
:
	IN
	| NOT_IN
	| HAS
	| CONTAINS
;

OPS
:
	(
		EQ
		| NEQ
		| GTE
		| LTE
		| GT
		| LT
	)
;

BETWEEN
:
	'between'
;

function
:
	'count'
;

count_function
:
	'count'
;

sum_function
:
	'sum' '(' field ')'
;

AND
:
	'AND'
;

OR
:
	'OR'
	| 'or'
;

NOT
:
	'NOT'
	| 'not'
;

HAS
:
	'has'
;

CONTAINS
:
	'contains'
;

IN
:
	'in'
	| 'IN'
;

NOT_IN
:
	'NOT IN'
	| 'not in'
;

EQ
:
	'='
;

NEQ
:
	'!='
;

GTE
:
	'>='
	| '=>'
;

LTE
:
	'<='
	| '=<'
;

GT
:
	'>'
;

LT
:
	'<'
;

NUMBER
:
	DIGIT+
	| DIGIT+ '.' DIGIT+
	| '.' DIGIT+
;

QTEXT
:
	'"'
	(
		ESC
		| .
	)*? '"'
;

UQTEXT
:
	~[ ()=,<>!|\r\n]+
;

fragment
DIGIT
:
	[0-9]
;

fragment
ESC
:
	'\\"'
	| '\\\\'
;

WS
:
	[ \t\r\n]+ -> skip
;
