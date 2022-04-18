create view breakfast_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         fat.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM diet_plan diet
	JOIN breakfast breakfast ON breakfast.id = diet.breakfast_id
    --JOIN lunch lunch ON lunch.id = diet.lunch_id
   -- JOIN dinner dinner ON dinner.id = diet.dinner_id
    JOIN ch ch ON ch.id = breakfast.ch_id
    JOIN fat fat on fat.id = breakfast.fat_id
    JOIN protein protein ON protein.id = breakfast.pr_id
    JOIN fruit fruit ON fruit.id = breakfast.fr_id
    JOIN vegetable vg ON vg.id = breakfast.veg_id

WHERE 1 = 1;

--

create view lunch_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         fat.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM diet_plan diet
	--JOIN breakfast breakfast ON breakfast.id = diet.breakfast_id
    JOIN lunch lunch ON lunch.id = diet.lunch_id
   -- JOIN dinner dinner ON dinner.id = diet.dinner_id
    JOIN ch ch ON ch.id = lunch.ch_id
    JOIN fat fat on fat.id = lunch.fat_id
    JOIN protein protein ON protein.id = lunch.pr_id
    JOIN fruit fruit ON fruit.id = lunch.fr_id
    JOIN vegetable vg ON vg.id = lunch.veg_id

WHERE 1 = 1;

--

create view dinner_v(
    ch,
    fat,
    protein,
    fruit,
    vegetable

    ) AS SELECT
         ch.name AS ch,
         fat.name AS fat,
         protein.name AS protein,
         fruit.name AS fruit,
         vg.name AS vegetale

FROM diet_plan diet
	--JOIN breakfast breakfast ON breakfast.id = diet.breakfast_id
    --JOIN lunch lunch ON lunch.id = diet.lunch_id
    JOIN dinner dinner ON dinner.id = diet.dinner_id
    JOIN ch ch ON ch.id = dinner.ch_id
    JOIN fat fat on fat.id = dinner.fat_id
    JOIN protein protein ON protein.id = dinner.pr_id
    JOIN fruit fruit ON fruit.id = dinner.fr_id
    JOIN vegetable vg ON vg.id = dinner.veg_id

WHERE 1 = 1;