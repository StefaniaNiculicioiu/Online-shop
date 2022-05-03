package ro.sd.a2.entity;

import org.hibernate.annotations.GenericGenerator;
import ro.sd.a2.utils.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "total_price")
    private String totalPrice;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "status")
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private  Client client;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
