import Header from './components/header';
import SalesCard from './components/SalesCard';
import"./index.css";

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className='dsmeta-container'>
            <SalesCard></SalesCard>
          </div>
        </section>
      </main>
    </>    
  )
}

export default App
