import "./App.css"
import GetDataHook from "./components/hooks/http/GetDataHook"
import IntervalHookCounter from "./components/hooks/IntervalHookCounter"

function App() {
  return (
    <div className="App">
      <GetDataHook />
      {/*<IterateWithHook />
      <HookForm />
      <HookCounter />
       <RefsComponent /> 
      <ParentComponent />
      <ParentInput />
      <ErrorBoundary>
        <Hero heroName={"Pattabhi"} />
      </ErrorBoundary>
      <ErrorBoundary>
        <Hero heroName={"Janaki Ramu"} />
      </ErrorBoundary>
      <ErrorBoundary>
        <Hero heroName={"Sravani"} />
      </ErrorBoundary>
      <ErrorBoundary>
        <Hero heroName={"Juhitha"} />
      </ErrorBoundary>
      <ErrorBoundary>
        <Hero heroName={"Joker"} />
      </ErrorBoundary>
      <ClickedCounterTwo
        incrementCounter={CounterIncrement.incrementCounter()}
      />
      <HoverCounterTwo incrementCounter={CounterIncrement.incrementCounter()} /> 
      <CounterIncrement
        render={(count, countIncrement) => {
          return (
            <ClickedCounterTwo
              count={count}
              incrementCounter={countIncrement}
            />
          )
        }}
      />

      <CounterIncrement
        render={(count, countIncrement) => {
          return (
            <HoverCounterTwo count={count} incrementCounter={countIncrement} />
          )
        }}
      />*/}
    </div>
  )
}

export default App
