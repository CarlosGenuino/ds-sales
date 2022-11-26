import './styles.css';
import notificationIcon from '../../assets/img/notification-icon.svg';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';

interface ButtonProps{
    id: number
}
    


function NotificationButton(props: ButtonProps){
    const onClick = ()=> {
        const id = props.id;
        axios.patch(`${BASE_URL}/sales/${id}`)
        .then(r => {
            console.log(r.data);
        }).catch(e => {
            console.log(e);
            
        })
    }

    return (
        <div className='dsmeta-red-btn'>
            <img src={notificationIcon} alt="Notificar" onClick={onClick} />
        </div>
    )
}

export default NotificationButton;