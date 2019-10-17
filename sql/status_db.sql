INSERT INTO `b2bdaddy`.`status` (status_name)
SELECT * FROM (SELECT 'PUBLISHED') AS tmp
WHERE NOT EXISTS (
    SELECT status_name FROM `b2bdaddy`.`status` WHERE status_name = 'PUBLISHED'
) LIMIT 1;

INSERT INTO `b2bdaddy`.`status` (status_name)
SELECT * FROM (SELECT 'DELETED') AS tmp
WHERE NOT EXISTS (
    SELECT status_name FROM `b2bdaddy`.`status` WHERE status_name = 'DELETED'
) LIMIT 1;

INSERT INTO `b2bdaddy`.`status` (status_name)
SELECT * FROM (SELECT 'CREATED') AS tmp
WHERE NOT EXISTS (
    SELECT status_name FROM `b2bdaddy`.`status` WHERE status_name = 'CREATED'
) LIMIT 1;