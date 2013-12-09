ALTER TABLE project DROP CONSTRAINT FK_project_CREATOR_NAME
ALTER TABLE model DROP CONSTRAINT FK_model_OWNER_ID
ALTER TABLE model_version DROP CONSTRAINT FK_model_version_MODELID
ALTER TABLE model_version DROP CONSTRAINT FK_model_version_MODIFIER_NAME
ALTER TABLE contributors DROP CONSTRAINT FK_contributors_contributors_NAME
ALTER TABLE contributors DROP CONSTRAINT FK_contributors_contributedProjects_ID
ALTER TABLE managers DROP CONSTRAINT FK_managers_administrators_NAME
ALTER TABLE managers DROP CONSTRAINT FK_managers_managedProjects_ID
ALTER TABLE participants DROP CONSTRAINT FK_participants_participants_NAME
ALTER TABLE participants DROP CONSTRAINT FK_participants_participatedProjects_ID
DROP TABLE udyat_user CASCADE
DROP TABLE project CASCADE
DROP TABLE model CASCADE
DROP TABLE model_version CASCADE
DROP TABLE contributors CASCADE
DROP TABLE managers CASCADE
DROP TABLE participants CASCADE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
