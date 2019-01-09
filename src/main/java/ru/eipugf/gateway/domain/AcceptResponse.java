package ru.eipugf.gateway.domain;

/**
 * Объект с идентификатором задачи.
 * @since 0.0.1
 * @author eipugf
 */
public class AcceptResponse {
    /**
     * Идентификатор задачи.
     */
    private final String taskId;

    public AcceptResponse(String taskId) {
        this.taskId = taskId;
    }

    /**
     * Метод получения идентификатора задания.
     * @return идентфикатор задания.
     */
    public String getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "AcceptResponse{" +
                "taskId='" + taskId + '\'' +
                '}';
    }
}
