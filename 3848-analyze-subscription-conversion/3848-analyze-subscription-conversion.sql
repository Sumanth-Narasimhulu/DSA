WITH freeTrialUsers AS (
    SELECT DISTINCT user_id
    FROM userActivity
    WHERE activity_type = 'free_trial'
),
paidUsers AS (
    SELECT DISTINCT user_id
    FROM userActivity
    WHERE activity_type = 'paid'
),
convertedUsers AS (
    SELECT ft.user_id
    FROM freeTrialUsers ft
    INNER JOIN paidUsers pu ON ft.user_id = pu.user_id
),
res AS (
    SELECT cu.user_id AS converted_user_id,
           ua.activity_date,
           ua.activity_type,
           ua.activity_duration
    FROM convertedUsers cu
    LEFT JOIN userActivity ua ON cu.user_id = ua.user_id
),
aveFreetrial AS (
    SELECT r.converted_user_id AS user_id,
           ROUND(AVG(activity_duration), 2) AS trial_avg_duration
    FROM res r
    WHERE activity_type = 'free_trial'
    GROUP BY user_id
),
avePaid AS (
    SELECT r.converted_user_id AS user_id,
           ROUND(AVG(activity_duration), 2) AS paid_avg_duration
    FROM res r
    WHERE activity_type = 'paid'
    GROUP BY user_id
)
SELECT a.user_id, a.trial_avg_duration, b.paid_avg_duration
FROM aveFreetrial a
JOIN avePaid b ON a.user_id = b.user_id;
