alter table point_history_entity add source varchar(255) null;

alter table point_history_entity add source_link varchar(255) null;

SET @permission_max_id = (SELECT max(id) FROM permission_entity);
SET @permission_next_val = (SELECT next_val FROM permission_entity_seq);
SET @permission_id_1 = (@permission_max_id + 1);

INSERT INTO permission_entity (id, created_by, created_on, deleted, updated_by, updated_on, version, alias, case_insensitive, method, name, overview, sort, type, matcher_id)
VALUES (@permission_id_1, null, now(), false, null, now(), 0, '[points] GET points/histories/users/{userId}', false, 0, '/points/histories/users/{userId}', null, 0, 0, null);

UPDATE permission_entity_seq t SET t.next_val = @permission_max_id + 50 + 1 WHERE next_val = @permission_next_val;
