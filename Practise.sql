SELECT num_race, name_disc, place, date_of_begin, time_of_begin, sex_race FROM stage, discipline, information
WHERE information.num_discipline = discipline.num_discipline
AND information.num_stage = stage.num_stage
AND name_disc = "Relay"