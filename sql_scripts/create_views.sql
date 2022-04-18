create view breakfast_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         f.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM plan p
    JOIN ch ch ON ch.id = p.ch_id
    JOIN fat f on p.fat_id = f.id
    JOIN protein protein ON protein.id = p.pr_id
    JOIN fruit fruit ON fruit.id = p.fr_id
    JOIN vegetable vg ON vg.id = p.veg_id

WHERE 1 = 1
AND ch.type='breakfast'
AND f.type='breakfast'
AND protein.type='breakfast'
AND fruit.type='breakfast'
AND vg.type='breakfast';

--

create view lunch_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         f.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM plan p
    JOIN ch ch ON ch.id = p.ch_id
    JOIN fat f on p.fat_id = f.id
    JOIN protein protein ON protein.id = p.pr_id
    JOIN fruit fruit ON fruit.id = p.fr_id
    JOIN vegetable vg ON vg.id = p.veg_id

WHERE 1 = 1
AND ch.type='lunch'
AND f.type='lunch'
AND protein.type='lunch'
AND fruit.type='lunch'
AND vg.type='lunch';

--

create view dinner_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         f.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM plan p
    JOIN ch ch ON ch.id = p.ch_id
    JOIN fat f on p.fat_id = f.id
    JOIN protein protein ON protein.id = p.pr_id
    JOIN fruit fruit ON fruit.id = p.fr_id
    JOIN vegetable vg ON vg.id = p.veg_id

WHERE 1 = 1
AND ch.type='dinner'
AND f.type='dinner'
AND protein.type='dinner'
AND fruit.type='dinner'
AND vg.type='dinner';


--day views:

