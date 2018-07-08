package ru.ftc.android.shifttemple.features.ivents.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
//
import retrofit2.Call;
import ru.ftc.android.shifttemple.features.Events.domain.model.Ivent;
import ru.ftc.android.shifttemple.features.Events.domain.model.Success;
import ru.ftc.android.shifttemple.features.Events.domain.model.Wrapper;
import ru.ftc.android.shifttemple.network.Carry;
//
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created: samokryl
 * Date: 04.07.18
 * Time: 9:54
 */
@RunWith(MockitoJUnitRunner.class)
public class EventsDataSourceImplTest {

    private EventsDataSource dataSource;

    private final EventsApi api = mock(EventsApi.class);
    private final Events firstEvents = mock(Events.class);
    private final Events secondEvents = mock(Events.class);
    private final List<Events> EventsList = new ArrayList<>();
    private final String EventsId = "123";

    @Before
    public void setUp() {
        eventList.add(firstEvent);
        eventList.add(secondEvent);

        listRepository = new IventslistRepositoryImpl(api);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(api);
    }

    @Test
    public void loadEvents() {
        Carry<List<Event>> carry = mock(Carry.class);
        Call<Wrapper<List<Ivent>>> listWrapper = mock(Call.class);
        when(api.loadIventList()).thenReturn(listWrapper);

        listRepository.loadIvents(carry);

        verify(api).loadIventList();
    }

    @Test
    public void getEvent() {
        Carry<Event> carry = mock(Carry.class);
        Call<Wrapper<Event>> wrapper = mock(Call.class);
        when(api.getEvent(eventId)).thenReturn(wrapper);

        ListDataSource.getEvent(eventId, carry);

        verify(api).getEvent(eventId);

    }
    
    @Test
    public void createIvent() {
        Carry<Ivent> carry = mock(Carry.class);
        Call<Wrapper<Ivent>> wrapper = mock(Call.class);
        when(api.createIvent(secondIvent)).thenReturn(wrapper);

        dataSource.createIvent(secondIvent, carry);

        verify(api).createIvent(secondIvent);
    }

    @Test
    public void deleteIvent() {
        Carry<Success> carry = mock(Carry.class);
        Call<Wrapper<Success>> wrapper = mock(Call.class);
        when(api.deleteIvent(iventId)).thenReturn(wrapper);

        dataSource.deleteIvent(iventId, carry);

        verify(api).deleteIvent(iventId);
    }
}