package com.event;

import java.lang.reflect.Method;

/**
 * @author Albert Beaupre
 */
public class HandlerExecutor {

	private Method method;
	private EventListener target;

	/**
	 * Represents a new HandlerExecutor, which is an individual 'listener'
	 * method that can be registered
	 * 
	 * @param target
	 *            The target listener
	 * @param method
	 *            The method from the listener.
	 */
	public HandlerExecutor(EventListener target, Method method) {
		if (method == null)
			throw new NullPointerException("Method may not be null.");
		if (target == null)
			throw new NullPointerException("Listener may not be null.");

		this.method = method;
		this.target = target;
	}

	/**
	 * The method to be executed.
	 * 
	 * @return The method to be executed.
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * The listener to have the method executed on
	 * 
	 * @return The listener to have the method executed on
	 */
	public EventListener getTarget() {
		return target;
	}

	/**
	 * The priority for this executor. This is found using the
	 * 
	 * @ActionHandler annotation on the method.
	 * @return The priority for this executor.
	 */
	public EventPriority getPriority() {
		EventHandler meta = getMethod().getAnnotation(EventHandler.class);
		return meta.priority();
	}

	/**
	 * Returns true if this EventListener is an Event consumer. Event consuming
	 * events won't be notified if the Event has already been consumed.
	 * 
	 * @return true if the EventListener is a consumer.
	 */
	public boolean isConsumer() {
		EventHandler meta = getMethod().getAnnotation(EventHandler.class);
		return meta.consumer();
	}

	/**
	 * Returns true if this EventListener should be skipped if the Event is
	 * cancelled. By default, this is true. When this is false, the
	 * EventListener will still be notified with events that have been
	 * cancelled.
	 * 
	 * @return true if the listener should be skipped if the event is cancelled
	 */
	public boolean isSkipIfCancelled() {
		EventHandler meta = getMethod().getAnnotation(EventHandler.class);
		return meta.skipIfCanceled();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof HandlerExecutor))
			return false;
		HandlerExecutor h = (HandlerExecutor) o;
		if (h.method == method && h.target == target)
			return true;
		else if (h.method.equals(method) && h.target.equals(target))
			return true;
		return false;
	}
}