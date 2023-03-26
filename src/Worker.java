public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskErrorListener errorCallback;
    private OnTaskDoneListener callback;

    public Worker (OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
