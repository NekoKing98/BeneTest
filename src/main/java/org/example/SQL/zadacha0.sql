WITH Relatives AS (SELECT DISTINCT dependant.HPRelatedPersonSysId AS id, dependant.contactRelationship
                    FROM HPPersonGeneric person
                    JOIN HPPersonDependant dependant ON person.sysId = dependant.sysId
                    WHERE person.personId = 'test')
SELECT person.familyName  ' '  person.givenName  ' '  person.middleName AS "ФИО",
        person.birthDate AS "Дата рождения", dependant.contactRelationship AS "Родственная связь"
FROM HPPersonGeneric person
JOIN Relatives ON person.sysId = Relatives.id