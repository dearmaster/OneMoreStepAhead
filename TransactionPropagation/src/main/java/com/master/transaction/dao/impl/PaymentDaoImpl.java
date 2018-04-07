package com.master.transaction.dao.impl;

import com.master.transaction.dao.PaymentDao;
import com.master.transaction.dao.support.AbstractBaseDao;
import com.master.transaction.model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl extends AbstractBaseDao<Payment> implements PaymentDao {
}