ALTER TABLE project DROP CONSTRAINT FK_project_CREATOR_NAME
ALTER TABLE model DROP CONSTRAINT FK_model_projectID
ALTER TABLE contributors DROP CONSTRAINT FK_contributors_contributors_NAME
ALTER TABLE contributors DROP CONSTRAINT FK_contributors_contributedProjects_ID
ALTER TABLE managers DROP CONSTRAINT FK_managers_administrators_NAME
ALTER TABLE managers DROP CONSTRAINT FK_managers_managedProjects_ID
ALTER TABLE participants DROP CONSTRAINT FK_participants_participants_NAME
ALTER TABLE participants DROP CONSTRAINT FK_participants_participatedProjects_ID
DROP TABLE udyat_user CASCADE
DROP TABLE project CASCADE
DROP TABLE model CASCADE
DROP TABLE contributors CASCADE
DROP TABLE managers CASCADE
DROP TABLE participants CASCADE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
