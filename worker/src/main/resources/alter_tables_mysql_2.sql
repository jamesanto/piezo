START TRANSACTION;

ALTER TABLE QRTZ_FIRED_TRIGGERS
  ADD COLUMN SCHED_TIME BIGINT(13) NOT NULL;

COMMIT;