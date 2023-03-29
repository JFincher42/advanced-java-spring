package platform.codingnomads.co.springdata.example.dml.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.transactional.models.Point;
import platform.codingnomads.co.springdata.example.dml.transactional.repositories.PointRepo;

import java.io.IOException;
import java.util.Random;

@Service
public class PointService {

    @Autowired
    PointRepo repo;

    //@Transactional I

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void doSomeWork() {
        Point p = new Point(1,1);
        repo.save(p);

        p = new Point(2,2);
        repo.save(p);

        /*
            In order to call the foo() method - we must have an existing transaction (MANDATORY)
         */
        foo();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void foo() {
        repo.findFirstByid(1L);
    }

    //@Transactional II

    @Transactional(timeout = 5)
    public void savePoint() {
        //create new point (1,1)
        Point p = new Point(1,1);

        //save new point
        repo.save(p);
    }

    @Transactional(timeout = 5)
    public void timeOutAfter5() {
        Point p = new Point(2,2);
        repo.save(p);
    }

    @Transactional(timeout = 1)
    public void triggerTimeout() throws InterruptedException {
        Thread.sleep(950);
        Point p = new Point(1,1);
        repo.save(p);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Point getPointById(Long id) {
        return repo.findFirstByid(id);
    }

    @Transactional(readOnly = true)
    public void noExceptionExpected() {
        Point p = repo.findFirstByid(1L);

        p.setX(5);

        repo.save(p);
    }

    @Transactional(rollbackFor = {IOException.class, ArithmeticException.class})
    public void rollbackFor() throws IOException, ArithmeticException {
        Point p = repo.findFirstByid(1L);
        p.setX(100);
        p.setX(100);
        repo.save(p);
        throw new IOException();
        //no change to DB
    }

    @Transactional(noRollbackFor = InterruptedException.class)
    public void noRollbackFor() throws InterruptedException{
        Point p = repo.findFirstByid(2L);
        p.setX(4);
        p.setX(20);
        repo.save(p);
        throw new InterruptedException();
        //changes still commit
    }

    @Transactional(timeout = 2)
    public void possibleTimeout() throws InterruptedException
    {
        // Might time out, might not
        Random rand = new Random();
        int delay = (int)(rand.nextFloat() * 1000) + 500;
        System.out.println("Delay is "+ delay);
        Thread.sleep(delay);

        Point p = new Point(20, 30);
        repo.save(p);
    }
}
