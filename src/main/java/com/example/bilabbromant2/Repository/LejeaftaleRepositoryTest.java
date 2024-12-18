package com.example.bilabbromant2.Repository;

import com.example.bilabbromant2.Model.Lejeaftale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LejeaftaleRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private LejeaftaleRepository lejeaftaleRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllLejeaftale() {
        Lejeaftale leje1 = new Lejeaftale(
                1, 101, "ST123",
                Date.valueOf("2024-06-01"),
                Date.valueOf("2024-06-10"),
                5000.0, "København", "Aktiv"
        );

        Lejeaftale leje2 = new Lejeaftale(
                2, 102, "ST456",
                Date.valueOf("2024-07-01"),
                Date.valueOf("2024-07-10"),
                4000.0, "Aarhus", "Inaktiv"
        );

        String sql = "SELECT * FROM lejeaftale";

        when(jdbcTemplate.query(eq(sql), any(RowMapper.class))).thenReturn(Arrays.asList(leje1, leje2));


        List<Lejeaftale> result = lejeaftaleRepository.fetchAllLejeaftale();

        assertEquals(2, result.size());
        assertEquals("ST123", result.get(0).getStelnummer());
        assertEquals("Aktiv", result.get(0).getLejeaftaleStatus());
        verify(jdbcTemplate, times(1)).query(eq(sql), any(RowMapper.class));
    }
}
