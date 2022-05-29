INSERT INTO mechanics (mechanics_id, type) VALUES
(1, 'COMPOUND'),
(2, 'ISOLATION'),
(3, 'NOT APPLICABLE');

INSERT INTO muscle (muscle_id, muscle_name) VALUES
(1, 'CHEST'),
(2, 'LOWER CHEST'),
(3, 'MIDDLE CHEST'),
(4, 'UPPER CHEST'),
(5, 'FOREARMS'),
(6, 'LATS'),
(7, 'MIDDLE BACK'),
(8, 'LOWER BACK'),
(9, 'NECK'),
(10, 'QUADRICEPS'),
(11, 'HAMSTRINGS'),
(12, 'CALVES'),
(13, 'TRICEPS'),
(14, 'TRAPS'),
(15, 'SHOULDERS'),
(16, 'ABDOMINALS'),
(17, 'GLUTES'),
(18, 'BICEPS'),
(19, 'ADDUCTORS'),
(20, 'ABDUCTORS'),
(21, 'OBLIQUES'),
(22, 'NONE');

INSERT INTO exercise_type (exercise_type_id, type) VALUES
(1, 'CARDIO'),
(2, 'OLYMPIC WEIGHTLIFTING'),
(3, 'PLYOMETRICS'),
(4, 'POWERLIFTING'),
(5, 'STRENGTH'),
(6, 'STRETCHING'),
(7, 'STRONGMAN');

INSERT INTO exercise_equipment (exercise_equipment_id, equipment) VALUES
(1, 'BENCH'),
(2, 'DUMBBELL'),
(3, 'BARBELL'),
(4, 'KETTLEBELL'),
(5, 'PULL-UP BAR'),
(6, 'TREADMILL'),
(7, 'STATIONARY BICYCLE'),
(8, 'ROWING MACHINE'),
(9, 'MEDICINE BALL'),
(10, 'AB ROLLER WHEEL'),
(11, 'PLYO BOX'),
(12, 'JUMP ROPE'),
(13, 'WEIGHT PLATES'),
(14, 'GYMNASTIC RINGS'),
(15, 'DIP BAR'),
(16, 'NONE');

INSERT INTO workout_level (workout_level_id, level) VALUES
(1, 'BEGINNER'),
(2, 'INTERMEDIATE'),
(3, 'EXPERT');

INSERT INTO workout (workout_id, description, reps, sets, time_between_sets, workout_duration, workout_example_video_url, workout_name, exercise_type_id, mechanics_id, workout_level_id) VALUES
(1, 'The bench press is a compound exercise that targets the muscles of the upper body. It involves lying on a bench and pressing weight upward using either a barbell or a pair of dumbbells. During a bench press, you lower the weight down to chest level and then press upwards while extending your arms.', 5, 10, 30, 10, 'www.example.com', 'BENCH PRESS', 5, 1, 2),
(2, 'With your back straight, core engaged, and balls of your feet firmly in the straps, push back first with the lower body, then use your upper back to pull hands toward your chest. Release your arms toward the base and bend your knees to glide back to starting position. Think: legs, arms, arms, legs.', 0, 0, 0, 30, 'www.example.com', 'ROWING EXERCISE', 1, 1, 1),
(3, 'The ring dip is to the bar dip as the squat is to the leg press. The movement requires upper-body strength, stability, and control while bringing the shoulders through full extension. Practicing the ring dip will develop upper-body pressing strength as well as a foundation for more advanced gymnastics movements.', 3, 12, 15, 10, 'www.example.com', 'OLYMPIC RING DIP', 5, 1, 3),
(4, 'Place the heel or ankle of one leg on something about waist high or a little lower. Bend at your hips to bring the front of your trunk towards your thigh. For best results, keep your back straight. A straight back will also provide some protection for your spine. ', 3, 10, 60, 10, 'www.example.com', 'STANDING HAMSTRING STRETCH', 6, 3, 1);

INSERT INTO primary_workout_muscles (workout_id, muscle_id) VALUES
(1, 1),
(2, 15),
(2, 13),
(2, 17),
(2, 10),
(2, 18),
(2, 11),
(2, 12),
(2, 21),
(3, 15),
(3, 16),
(3, 2),
(3, 3),
(4, 11);

INSERT INTO secondary_workout_muscles (workout_id, muscle_id) VALUES
(1, 22),
(2, 22),
(4, 22),
(3, 7),
(3, 4),
(3, 15);

INSERT INTO exercise_equipment_for_workout (workout_id, exercise_equipment_id) VALUES
(1, 1),
(1, 3),
(1, 13),
(2, 8),
(4, 16),
(3, 14);