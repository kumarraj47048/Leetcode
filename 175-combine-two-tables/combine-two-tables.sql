# Write your MySQL query statement below
select firstName, lastName, city, state from Person left join address on Person.personId=Address.personId;