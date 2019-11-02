package com.yuruicai.test.server.config;

import com.yuruicai.test.server.springcloud.domain.User;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
/**
 *     // 指定当前标注方法处理事务的类型
 * 	TransactionPhase phase() default TransactionPhase.AFTER_COMMIT;
 *
 *     // 用于指定当前方法如果没有事务，是否执行相应的事务事件监听器
 * 	boolean fallbackExecution() default false;
 *
 *     // 与classes属性一样，指定了当前事件传入的参数类型，指定了这个参数之后就可以在监听方法上
 *     // 直接什么一个这个参数了
 *        @AliasFor(annotation = EventListener.class, attribute = "classes")
 * 	Class<?>[] value() default {};
 *
 *     // 作用于value属性一样，用于指定当前监听方法的参数类型
 *    @AliasFor(annotation = EventListener.class, attribute = "classes")
 * 	Class<?>[] classes() default {};
 *
 *     // 这个属性使用Spring Expression Language对目标类和方法进行匹配，对于不匹配的方法将会过滤掉
 * 	String condition() default "";
 * */
@Component
public class TransactionalListener {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(PayloadApplicationEvent<User> event) {
        System.out.println("before commit, id: " + event.getPayload().getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(PayloadApplicationEvent<User> event) {
        System.out.println("after commit, id: " + event.getPayload().getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void afterCompletion(PayloadApplicationEvent<User> event) {
        System.out.println("after completion, id: " + event.getPayload().getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterRollback(PayloadApplicationEvent<User> event) {
        System.out.println("after rollback, id: " + event.getPayload().getId());
    }
}
